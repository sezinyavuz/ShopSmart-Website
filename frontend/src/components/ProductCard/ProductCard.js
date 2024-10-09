import React from 'react';
import { Link } from 'react-router-dom'; // Import Link
import styles from './ProductCard.module.css';



const ProductCard = ({ product }) => (

    
    <Link to={`/product/${product.id}`} className={styles.link}>
        <div className={styles.productCard}>
            <img src={product.imageUrl} alt={product.productName} />
            <h3>{product.productName}</h3>
            <p>{product.category}</p>
            <div className={styles.productName}>{product.productName}</div>
            <div className={styles.rating}>{product.rating}</div>
            <div className={styles.price}>{product.price}</div>
        </div>
    </Link>
);

export default ProductCard;
