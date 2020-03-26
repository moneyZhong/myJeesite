/**
 */
package com.wolfking.jeesite.common.filter;

import com.wolfking.jeesite.common.utils.SpringContextHolder;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

import com.wolfking.jeesite.common.utils.SpringContextHolder;

/**
 * 页面高速缓存过滤器
 */
public class PageCachingFilter extends SimplePageCachingFilter {

	private CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);
	
	@Override
	protected CacheManager getCacheManager() {
		this.cacheName = "pageCachingFilter";
		return cacheManager;
	}
	
}
