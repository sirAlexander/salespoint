/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.salespointframework.inventory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.salespointframework.catalog.Product;
import org.salespointframework.quantity.Quantity;

/**
 * An {@link AbstractInventoryItem} that requires a unique one-to-one relationship to a {@link Product} instance.
 * 
 * @author Oliver Gierke
 */
@Entity
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class InventoryItem extends AbstractInventoryItem<InventoryItem> {

	@ManyToOne //
	private Product product;

	/**
	 * Creates a new {@link InventoryItem} for the given {@link Product} and {@link Quantity}.
	 * 
	 * @param product the {@link Product} for this {@link InventoryItem}, must not be {@literal null}.
	 * @param quantity the initial {@link Quantity} for this {@link InventoryItem}, must not be {@literal null}.
	 */
	public InventoryItem(Product product, Quantity quantity) {

		super(product, quantity);

		this.product = product;
	}

	/*
	 * (non-Javadoc)
	 * @see org.salespointframework.inventory.InventoryItem#getProduct()
	 */
	protected Product getProduct() {
		return this.product;
	}
}
