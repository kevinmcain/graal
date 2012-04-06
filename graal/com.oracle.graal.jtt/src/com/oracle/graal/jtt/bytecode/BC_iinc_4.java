/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
 */
/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.graal.jtt.bytecode;

import org.junit.*;

/*
 */
public class BC_iinc_4 {

    public static int test(int a) {
        int arg = a;
        arg += 512;
        return arg;
    }

    @Test
    public void run0() throws Throwable {
        Assert.assertEquals(513, test(1));
    }

    @Test
    public void run1() throws Throwable {
        Assert.assertEquals(514, test(2));
    }

    @Test
    public void run2() throws Throwable {
        Assert.assertEquals(516, test(4));
    }

    @Test
    public void run3() throws Throwable {
        Assert.assertEquals(511, test(-1));
    }

}