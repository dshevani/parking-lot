package com.jek.go.common;

import java.util.Map;

/** Base class for all Resource Manager **/

public abstract class AbstractResourceManager<Resource, Tenant> {
	
	protected Map<Resource, Tenant> resourceTenantMap;
	
	public AbstractResourceManager(Map<Resource, Tenant> resourceTenantMap) {
		this.resourceTenantMap = resourceTenantMap;
	}
	
	public AbstractResourceManager() {

	}
	
	public Map<Resource, Tenant> getResourceTenantMap() {
		return resourceTenantMap;
	}

	public void setResourceTenantMap(Map<Resource, Tenant> resourceTenantMap) {
		this.resourceTenantMap = resourceTenantMap;
	}

	public abstract Resource getAvailableResource();
	
	public abstract boolean bookAvailableResource(Tenant tenant);
	
	public abstract boolean bookResource(Resource resource, Tenant tenant);
	
	public abstract boolean releaseResource(Resource resource);
	
	public abstract boolean releaseResourceById(int resourceId);
	
	public abstract boolean printStatus();
		
}
