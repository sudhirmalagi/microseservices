package com.product.service;

import com.product.resource.ProductServiceResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ProductService extends Service<ProductServiceConfiguration>{

	public static void main(String[] args) throws Exception{
		new ProductService().run(new String[] {"server","application.yml"});
	}
	
	@Override
	public void initialize(Bootstrap<ProductServiceConfiguration> arg0) {
		
		
	}

	@Override
	public void run(ProductServiceConfiguration serviceConfig, Environment environment) throws Exception {
		environment.addResource(new ProductServiceResource(serviceConfig));
		}

}
