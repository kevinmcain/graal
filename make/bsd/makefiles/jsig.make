#
# Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
# DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
#
# This code is free software; you can redistribute it and/or modify it
# under the terms of the GNU General Public License version 2 only, as
# published by the Free Software Foundation.
#
# This code is distributed in the hope that it will be useful, but WITHOUT
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
# FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
# version 2 for more details (a copy is included in the LICENSE file that
# accompanied this code).
#
# You should have received a copy of the GNU General Public License version
# 2 along with this work; if not, write to the Free Software Foundation,
# Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
#
# Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
# or visit www.oracle.com if you need additional information or have any
# questions.
#  
#

# Rules to build signal interposition library, used by vm.make

# libjsig.so: signal interposition library
JSIG   = jsig

ifeq ($(OS_VENDOR), Darwin)
  LIBJSIG   = lib$(JSIG).dylib
else
  LIBJSIG   = lib$(JSIG).so
endif

JSIGSRCDIR = $(GAMMADIR)/src/os/$(Platform_os_family)/vm

DEST_JSIG  = $(JDK_LIBDIR)/$(LIBJSIG)

LIBJSIG_MAPFILE = $(MAKEFILES_DIR)/mapfile-vers-jsig

# On Bsd we really dont want a mapfile, as this library is small 
# and preloaded using LD_PRELOAD, making functions private will 
# cause problems with interposing. See CR: 6466665
# LFLAGS_JSIG += $(MAPFLAG:FILENAME=$(LIBJSIG_MAPFILE))

LFLAGS_JSIG += -D_GNU_SOURCE -pthread $(LDFLAGS_HASH_STYLE)

# DEBUG_BINARIES overrides everything, use full -g debug information
ifeq ($(DEBUG_BINARIES), true)
  JSIG_DEBUG_CFLAGS = -g
endif

$(LIBJSIG): $(JSIGSRCDIR)/jsig.c $(LIBJSIG_MAPFILE)
	@echo Making signal interposition lib...
	$(QUIETLY) $(CC) $(SYMFLAG) $(ARCHFLAG) $(SHARED_FLAG) $(PICFLAG) \
                         $(LFLAGS_JSIG) $(JSIG_DEBUG_CFLAGS) -o $@ $<

install_jsig: $(LIBJSIG)
	@echo "Copying $(LIBJSIG) to $(DEST_JSIG)"
	$(QUIETLY) cp -f $(LIBJSIG) $(DEST_JSIG) && echo "Done"

.PHONY: install_jsig
