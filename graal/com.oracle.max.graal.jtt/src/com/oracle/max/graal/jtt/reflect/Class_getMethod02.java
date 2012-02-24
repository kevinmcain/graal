/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.max.graal.jtt.reflect;

import org.junit.*;

/*
 */
public class Class_getMethod02 {

    static String field;

    public static String test(int arg) throws NoSuchMethodException {
        if (arg == 0) {
            return Class_getMethod02.class.getMethod("test").getName();
        } else if (arg == 1) {
            return Class_getMethod02.class.getMethod("test", int.class).getName();
        } else if (arg == 2) {
            return Class_getMethod02.class.getMethod("main").getName();
        } else if (arg == 3) {
            return Class_getMethod02.class.getMethod("main", String[].class).getName();
        } else if (arg == 4) {
            return Class_getMethod02.class.getMethod("<init>").getName();
        } else if (arg == 5) {
            return Class_getMethod02.class.getMethod("<clinit>").getName();
        }
        return null;
    }

    public static void main(String[] args) {
        field = args[0];
    }

    @Test(expected = java.lang.NoSuchMethodException.class)
    public void run0() throws Throwable {
        test(0);
    }

    @Test
    public void run1() throws Throwable {
        Assert.assertEquals("test", test(1));
    }

    @Test(expected = java.lang.NoSuchMethodException.class)
    public void run2() throws Throwable {
        test(2);
    }

    @Test
    public void run3() throws Throwable {
        Assert.assertEquals("main", test(3));
    }

    @Test(expected = java.lang.NoSuchMethodException.class)
    public void run4() throws Throwable {
        test(4);
    }

    @Test(expected = java.lang.NoSuchMethodException.class)
    public void run5() throws Throwable {
        test(5);
    }

    @Test
    public void run6() throws Throwable {
        Assert.assertEquals(null, test(6));
    }

}