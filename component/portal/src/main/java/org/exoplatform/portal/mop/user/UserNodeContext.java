/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.portal.mop.user;

import org.exoplatform.portal.mop.navigation.NodeContext;
import org.exoplatform.portal.mop.navigation.NodeModel;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 */
public class UserNodeContext implements NodeModel<UserNode>
{

   /** The related navigation. */
   final UserNavigation navigation;

   /** . */
   final UserNodeFilterConfig filterConfig;

   /** . */
   private UserNodeFilter filter;

   public UserNodeContext(UserNavigation navigation, UserNodeFilterConfig filterConfig)
   {
      this.filterConfig = filterConfig;
      this.navigation = navigation;
   }

   public NodeContext<UserNode> getContext(UserNode node)
   {
      return node.context;
   }

   public UserNode create(NodeContext<UserNode> context)
   {
      return new UserNode(this, context);
   }

   void filter(UserNode userNode)
   {
      if (filterConfig != null)
      {
         if (filter == null)
         {
            filter = new UserNodeFilter(navigation.portal, filterConfig);
         }
         userNode.context.filter(filter);
      }
   }
}
