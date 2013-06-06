package com.smash.revolance.ui.explorer.reporter.api;

/*
        This file is part of Revolance UI Suite.

        Revolance UI Suite is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        Revolance UI Suite is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with Revolance UI Suite.  If not, see <http://www.gnu.org/licenses/>.
*/

import com.smash.revolance.ui.explorer.application.Application;
import com.smash.revolance.ui.explorer.reporter.Reporter;

import java.io.File;

/**
 * User: wsmash
 * Date: 20/02/13
 * Time: 10:47
 */
public abstract class BaseReporter implements Reporter
{
    private final Application application;

    public BaseReporter(Application application)
    {
        this.application = application;
    }

    public abstract void doReport(File file) throws Exception;
}