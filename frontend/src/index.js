// src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './index.css';
import App from './pages/App';
import AccountManagement from './pages/AccountManagmentPage/AccountManagement';
import ProductPage from './pages/ProductPage/ProductPage';
import AuthForm from './pages/LoginPage/AuthForm';
import { AuthProvider } from './context/AuthContext';
import MemberHomePage from './pages/MemberHomePage';
import MerchantHomePage from './pages/MerchantHomePage';
import MerchantProductsPage from './pages/MerchantProductPage/MerchantProductPage';


const Root = () => (
  <AuthProvider>
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/account-management" element={<AccountManagement />} />
        <Route path="/product/:id" element={<ProductPage />} />
        <Route path="/login" element={<AuthForm />} />
        <Route path="/member-home" element={<MemberHomePage />} />
        <Route path="/merchant-home" element={<MerchantHomePage />} />
        <Route path="/merchant-products" element={<MerchantProductsPage />} />

      </Routes>
    </Router>
  </AuthProvider>
);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Root />
  </React.StrictMode>
);
