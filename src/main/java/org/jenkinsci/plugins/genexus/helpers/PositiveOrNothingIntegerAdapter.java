/*
 * The MIT License
 *
 * Copyright 2020 GeneXus S.A..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.genexus.helpers;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;


/**
 *
 * @author jlr
 *
 * For TeamWorkService2.GetVersions() GXserver exports ParentId only if if it's
 * non zero.
 *
 * This adapter converts to null when the value is not positive (so as to avoid
 * writing it).
 *
 * This makes sure the roundtrip (converting the received XML string to Document
 * and back to string) returns the same result.
 */
public class PositiveOrNothingIntegerAdapter extends XmlAdapter<String, Integer> {
    @Override
    public Integer unmarshal(String strValue) throws Exception {
        return Integer.parseInt(strValue);
    }

    @Override
    public String marshal(Integer intValue) throws Exception {
        return (intValue > 0) ? intValue.toString() : null;
    }
}
