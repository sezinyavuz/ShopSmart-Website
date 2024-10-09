// src/components/ProductGrid.js
import React from 'react';
import ProductCard from '../ProductCard/ProductCard';
import styles from '../ProductGrid/ProductGrid.module.css';

const ProductGrid = ({ products }) => (
  <div className={styles.productGrid}>
    {products.map((product) => (
      <ProductCard key={product.id} product={product} />
    ))}
  </div>
);

export default ProductGrid;

// src/components/ProductGrid.module.css
/* Add CSS here */