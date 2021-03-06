package com.smash.revolance.ui.explorer;

/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revolance-UI-Explorer
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2012 - 2013 RevoLance
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import com.smash.revolance.ui.model.user.User;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * User: wsmash
 * Date: 19/10/13
 * Time: 22:29
 */
public class ExplorationService implements IExplorer
{
    private static Logger LOG = Logger.getLogger(ExplorationService.class);;
    // private IConfiguration internalConfiguration = new Configuration("conf");

    @Override
    public void explore(ExplorationConfiguration configuration) throws IOException
    {
        // LOG.addAppender(new FileAppender(new SimpleLayout(), internalConfiguration.getLogFile().getAbsolutePath()));

        User user = new User( configuration.getId(), configuration.getUrl() );
        user.setDomain( configuration.getDomain() );

        user.setFollowLinks( configuration.isFollowLinksEnabled() );
        user.setFollowButtons( configuration.isFollowButtonsEnabled() );

        user.enablePageScreenshot( true );
        user.enablePageElementScreenshot( true );

        user.setBrowserType( configuration.getBrowserType() );
        user.setBrowserWidth( configuration.getBrowserWidth() );
        user.setBrowserHeight( configuration.getBrowserHeight() );

        user.setExcludedLinks( configuration.getExcludedLinks() );
        user.setExcludedButtons(configuration.getExcludedButtons());

        // user.setDriverPath(internalConfiguration.getDriverPath());
        // user.setBrowserBinary(internalConfiguration.getBrowserPath());

        LOG.info("Launching exploration id: " + user.getId() + ". Log file: " + configuration.getLogFile());

        FileAppender logger = new FileAppender(new SimpleLayout(), configuration.getLogFile().getAbsolutePath());

        UserExplorer explorer = new UserExplorer( user, logger, configuration.getReportFile(), configuration.getTimeout() );
        explorer.explore();
    }

}
