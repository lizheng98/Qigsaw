/*
 * MIT License
 *
 * Copyright (c) 2019-present, iQIYI, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.iqiyi.android.qigsaw.core.splitreport;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * report install status of split APKs, called in main process.
 */
public interface SplitInstallReporter {

    /**
     * Using {@code startInstall} to install modules.
     * When all modules are installed successfully,
     * this method will be invoked.
     *
     * @param requestModuleNames module names that you request to install.
     * @param cost               time in ms.
     */
    void onStartInstallOK(List<String> requestModuleNames, long cost);

    /**
     * Using {@code startInstall} to install modules,
     * When one module is installed failed,
     * installation would be cancelled and this method will be invoked.
     *
     * @param requestModuleNames module names that you request to install.
     * @param error              {@link SplitInstallError}
     * @param cost               time in ms.
     */
    void onStartInstallFailed(List<String> requestModuleNames, @NonNull SplitInstallError error, long cost);

    /**
     * Using {@code deferredInstall} to install modules.
     * When all modules are installed successfully,
     * this method will be invoked.
     *
     * @param requestModuleNames module names that you request to install.
     * @param cost               time in ms.
     */
    void onDeferredInstallOK(List<String> requestModuleNames, long cost);

    /**
     * Using {@code deferredInstall} to install modules.
     * When installations of all modules are done,
     * and at least one module failed,
     * this method will be invoked.
     *
     * @param requestModuleNames module names that you request to install.
     * @param errors             a list of {@link SplitInstallError}
     * @param cost               time in ms.
     */
    void onDeferredInstallFailed(List<String> requestModuleNames, @NonNull List<SplitInstallError> errors, long cost);

}
