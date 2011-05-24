/*
 * Copyright (C) 2010 eXo Platform SAS.
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

import java.util.List;

import org.exoplatform.portal.mop.SiteKey;
import org.exoplatform.portal.mop.navigation.NavigationServiceException;
import org.exoplatform.portal.mop.navigation.NodeChangeListener;
import org.exoplatform.portal.mop.navigation.NodeFilter;
import org.exoplatform.portal.mop.navigation.Scope;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public interface UserPortal
{

   /**
    * Returns the sorted list of current user navigations.
    *
    * @return the current user navigations
    * @throws Exception any exception
    */
   List<UserNavigation> getNavigations() throws Exception;

   /**
    * Returns a user navigation for a specified site key, null is returned when such navigation does not exist.
    *
    * @param key the site key
    * @return the corresponding user navigation
    * @throws Exception any exception
    */
   UserNavigation getNavigation(SiteKey key) throws Exception;

   /**
    * Load a user node from a specified user navigation with a custom scope.
    * The returned node is the root node of the navigation.
    *
    * @param navigation the user navigation
    * @param scope an optional scope
    * @param filterConfig an optional filter
    * @param listener an optional listener  @return the user node
    * @return the user node
    * @throws Exception any exception
    */
   UserNode getNode(UserNavigation navigation, Scope scope, UserNodeFilterConfig filterConfig, NodeChangeListener<UserNode> listener) throws Exception;

   /**
    * Update the specified content with the most recent state.
    *
    * @param node the node to update
    * @param scope the optional scope
    * @param listener an optional listener
    * @throws NullPointerException if the context argument is null
    * @throws IllegalArgumentException if the node has pending changes
    * @throws NavigationServiceException anything that would prevent the operation to succeed
    */
   void updateNode(UserNode node, Scope scope, NodeChangeListener<UserNode> listener) throws NullPointerException, IllegalArgumentException, NavigationServiceException;
   
   /**
    * Rebase the specified context with the most recent state.
    *
    * @param node the user node that will be rebased
    * @param scope the optional scope
    * @param listener the option node change listener
    * @throws NullPointerException if the context argument is null
    * @throws NavigationServiceException anything that would prevent the operation to succeed
    */
    void rebaseNode(UserNode node, Scope scope, NodeChangeListener<UserNode> listener) throws NullPointerException, NavigationServiceException;

   /**
    * Returns the default navigation path.
    *
    * @param filterConfig an optional filter
    * @return the default navigation path
    * @throws Exception any exception
    */
   NavigationPath getDefaultPath(UserNodeFilterConfig filterConfig) throws Exception;

   /**
    * Resolves and returns a navigation path among all user navigations for a specified path.
    *
    * @param filterConfig an optional filter
    * @param path the path
    * @return the navigation path
    * @throws Exception any exception
    */
   NavigationPath resolvePath(UserNodeFilterConfig filterConfig, String path) throws Exception;

   /**
    * Resolves and returns a navigation path for the specified navigation and for a specified path.
    *
    * @param navigation the navigation
    * @param filterConfig an optional filter
    * @param path the path  @return the navigation path
    * @return the navigation path
    * @throws Exception any exception
    */
   NavigationPath resolvePath(UserNavigation navigation, UserNodeFilterConfig filterConfig, String path) throws Exception;

   /**
    * Create a filter for the current user with the specified predicate.
    *
    * @param predicate the predicate to use
    * @return the scope
    */
   NodeFilter createFilter(UserNodeFilterConfig predicate);

}
