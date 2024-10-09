import React from 'react';
import { Link } from 'react-router-dom';
import styles from './ChangePassword.module.css';

const ChangePassword = () => {
  return (
    <div className={styles.changePasswordContainer}>
      <aside className={styles.sidebar}>
        <Link to="/profile" className={styles.sidebarLink}>Profile Information</Link>
        <Link to="/change-password" className={`${styles.sidebarLink} ${styles.active}`}>Change Password</Link>
      </aside>
      
    </div>
  );
};

export default ChangePassword;
