/**
 * Copyright (C) 2014 Couchbase, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALING
 * IN THE SOFTWARE.
 */
package com.pricing.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration and beans for couchbase bucket
 *
 * @author Simon Baslé
 * @since 1.0
 */
@Configuration
public class Database {

    @Value("${couchbase.nodes}")
    private List<String> nodes = new ArrayList<String>();

    @Value("${couchbase.bucket}")
    private String bucket;

    @Value("${couchbase.password}")
    private String password;

    public List<String> getNodes() {
        return nodes;
    }

    public String getBucket() {
        return bucket;
    }

    public String getPassword() {
        return password;
    }
    
    static List<String> list = Arrays.asList("aaa","ddd","bbbb");
    public static List<String> java7(List<String> list ){
    	Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		return list;
    }
    
    public static List<String> java8(List<String> list){
    	Collections.sort(list,(String a, String b) -> {
    		return a.compareTo(b);
    		});
		return list;
    	}
    
    
    	
    public static void main(String[] args) {
    
	}
}
