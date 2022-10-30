/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package ee.jakarta.tck.faces.test.servlet40.facelets;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

import ee.jakarta.tck.faces.test.util.arquillian.ITBase;

public class Spec1102IT extends ITBase {

    /**
     * @see com.sun.faces.facelets.component.UIRepeat
     * @see https://github.com/jakartaee/faces/issues/1102
     * @see https://github.com/eclipse-ee4j/mojarra/issues/5150
     */
    @Test
    public void testSpec1102() throws Exception {
        HtmlPage page = getPage("faces/spec1102.xhtml");

        assertValues(page);

        HtmlSubmitInput button = (HtmlSubmitInput) page.getHtmlElementById("form:submit");
        page = button.click();
        webClient.waitForBackgroundJavaScript(60000);

        assertValues(page);
    }

    private void assertValues(HtmlPage page) {
        assertTrue(page.getHtmlElementById("repeat1").asNormalizedText().equals("123"));
        assertTrue(page.getHtmlElementById("repeat2").asNormalizedText().equals("-3-2-10123"));
        assertTrue(page.getHtmlElementById("repeat3").asNormalizedText().equals("3210-1-2-3"));
        assertTrue(page.getHtmlElementById("repeat4").asNormalizedText().equals("-3-113"));
        assertTrue(page.getHtmlElementById("repeat5").asNormalizedText().equals("-3-2"));
        assertTrue(page.getHtmlElementById("repeat6").asNormalizedText().equals("-3"));
        assertTrue(page.getHtmlElementById("repeat7").asNormalizedText().equals("3"));
        assertTrue(page.getHtmlElementById("repeat8").asNormalizedText().equals("0123"));
    }
    
}
