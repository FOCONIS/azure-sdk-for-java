// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.identity;

import com.azure.core.annotation.Fluent;
import com.microsoft.aad.msal4j.ITokenCacheAccessAspect;

/**
 * Represents the Persistence Token Cache options used to setup the persistent access token cache.
 * It allows users to enable the persistent token cache and optionally configure its name. The
 * TokenCachePersistenceOptions can be configured directly on the Token Credential builders for the Token Credentials
 * that support it.
 *
 * @see com.azure.identity
 */
@Fluent
public final class TokenCachePersistenceOptions {
    private boolean unencryptedStorageAllowed;
    private String name;
    private ITokenCacheAccessAspect tokenCacheAccessAspect = null;

    /**
     * Constructs an instance of TokenCachePersistenceOptions.
     */
    public TokenCachePersistenceOptions() {
    }

    /**
     * Allows to use an unprotected file specified by <code>cacheFileLocation()</code> instead of
     * Gnome keyring on Linux. This is restricted by default. For other platforms this setting currently doesn't apply.
     *
     * @param unencryptedStorageAllowed The flag indicating if unencrypted storage is allowed for the cache or not.
     * @return An updated instance of the options bag.
     */
    public TokenCachePersistenceOptions setUnencryptedStorageAllowed(boolean unencryptedStorageAllowed) {
        this.unencryptedStorageAllowed = unencryptedStorageAllowed;
        return this;
    }

    /**
     * Gets the status whether unencrypted storage is allowed for the persistent token cache.
     *
     * @return The status indicating if unencrypted storage is allowed for the persistent token cache.
     */
    public boolean isUnencryptedStorageAllowed() {
        return this.unencryptedStorageAllowed;
    }

    /**
     * Set the name uniquely identifying the cache.
     *
     * @param name the name of the cache
     * @return the updated instance of the cache.
     */
    public TokenCachePersistenceOptions setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the name uniquely identifying the cache.
     *
     * @return the name of the cache.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set a tokenCacheAspect that ist notified before and after each access to the tokenCache.
     *
     * @param tokenCacheAccessAspect The ITokenCacheAccessAspect to be notified.
     * @return the updated instance of the cache.
     */
    public TokenCachePersistenceOptions setTokenCacheAccessAspect(ITokenCacheAccessAspect tokenCacheAccessAspect) {
        this.tokenCacheAccessAspect = tokenCacheAccessAspect;
        return this;
    }

    /**
     * Get the tokenCacheAspect that is currently set.
     *
     * @return tokenCacheAccessAspect The ITokenCacheAccessAspect currently set.
     */
    public ITokenCacheAccessAspect getTokenCacheAccessAspect() {
        return tokenCacheAccessAspect;
    }

}
