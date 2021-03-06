/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

#ifndef SHARE_VM_MEMORY_METASPACECOUNTERS_HPP
#define SHARE_VM_MEMORY_METASPACECOUNTERS_HPP

#include "runtime/perfData.hpp"

class MetaspaceCounters: public CHeapObj<mtClass> {
  friend class VMStructs;
  PerfVariable*      _capacity;
  PerfVariable*      _used;
  PerfVariable*      _max_capacity;
  static MetaspaceCounters* _metaspace_counters;
  void initialize(size_t min_capacity,
                  size_t max_capacity,
                  size_t curr_capacity,
                  size_t used);
  size_t calc_total_capacity();
 public:
  MetaspaceCounters();
  ~MetaspaceCounters();

  void update_capacity();
  void update_used();
  void update_max_capacity();

  void update_all();

  static void initialize_performance_counters();
  static void update_performance_counters();

};
#endif // SHARE_VM_MEMORY_METASPACECOUNTERS_HPP
