// src/index.js
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css'; 
import UserList from './component/Admin/User/UserList';
import AddUserPage from './component/Admin/User/AddUserPage';
import RoleList from './component/Admin/Role/RoleList';
import AddRolePage from './component/Admin/Role/AddRolePage';
import UserAddressList from './component/Admin/UserAddress/UserAddressList';
import AddUserAddress from './component/Admin/UserAddress/AddUserAddress';
// import AddImagePage from './component/User/AddImagePage';
import CategoryList from './component/Admin/Category/CategoryList';
import AddCategoryPage from './component/Admin/Category/AddCategoryPage';
import CategoryLV2List from './component/Admin/CategoryLV2/CategoryLV2List';
import AddCategoryLV2Page from './component/Admin/CategoryLV2/AddCategoryLV2Page';
import ImageUploadComponent from './component/Admin/User/ImageUploadComponent';
import ColorList from './component/Admin/Color/ColorList';
import AddColorPage from './component/Admin/Color/AddColorPage';
import SigninAdmin from './component/Admin/security/Signin';
import AdminProfile from './component/Admin/security/AdminProfile';
import UserProfile from './component/Admin/security/UserProfile';
import SignUpAdmin from './component/Admin/security/Signup';
import ProductListPage from './component/Admin/product/Productlist';
import AddProductPage from './component/Admin/product/AddProductPage';
import Login from './component/User/Login';
import OrderList from './component/Admin/Order/OrderList';
import OrderListByStatus1 from './component/Admin/Order/OrderListBystatus1';
import OrderListByStatus2 from './component/Admin/Order/OrderListBystatus2';
import OrderListByStatus3 from './component/Admin/Order/OrderListBystatus3';
import OrderListByPay1 from './component/Admin/Order/OrderListByPay1';
import OrderListByPay2 from './component/Admin/Order/OrderListByPay2';
import OrderListByCancelbad from './component/Admin/Order/OrderListByCancelbad';
import OrderListByCancelok from './component/Admin/Order/OrderListByCancel';
import AddproductImagePage from './component/Admin/product/AddImageProductPage';
import OrderEdit from './component/Admin/Order/OrderEdit';
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <Router>
    <React.StrictMode>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/user-list" element={<UserList />}  />
        <Route path="/add-user" element={<AddUserPage />}/>
        <Route path="/role-list" element={<RoleList />}  />
        <Route path="/add-role" element={<AddRolePage />}/>
        <Route path="/user-address-api" element={<UserAddressList />}/>
        <Route path="/add-user-address" element={<AddUserAddress />}/>
        <Route path="/category-list" element={<CategoryList />}/>
        <Route path="/add-category" element={<AddCategoryPage />}/>
        <Route path="/categorylv2-list" element={<CategoryLV2List />}/>
        <Route path="/add-category-level-2" element={<AddCategoryLV2Page />}/>
        <Route path="/add-category-level-2-add-image" element={<ImageUploadComponent />}/>
        <Route path="/color-list" element={<ColorList />}/>
        <Route path="/add-color" element={<AddColorPage />}/>
        <Route path="/admin/login" element={<SigninAdmin />}/>
        <Route path="/profile/admin" element={<AdminProfile />}/>
        <Route path="/profile/user" element={<UserProfile />}/>
        <Route path="/admin/signup" element={<SignUpAdmin />}/>
        <Route path="/product-list" element={<ProductListPage />}/>
        <Route path="/add-product" element={<AddProductPage />}/>
        <Route path="/order-list" element={<OrderList />}/>
        <Route path="/order-list-by-status-1" element={<OrderListByStatus1 />}/>
        <Route path="/order-list-by-status-2" element={<OrderListByStatus2 />}/>
        <Route path="/order-list-by-status-3" element={<OrderListByStatus3 />}/>
        <Route path="/order-list-by-pay-1" element={<OrderListByPay1 />}/>
        <Route path="/order-list-by-pay-2" element={<OrderListByPay2 />}/>
        <Route path="/order-list-by-cancel-ok" element={<OrderListByCancelok />}/>
        <Route path="/order-list-by-cancel-bad" element={<OrderListByCancelbad />}/>
        <Route path="/add-product-images" element={<AddproductImagePage />}/>
        <Route path="/order-edit" element={<OrderEdit />}/>
        <Route path="/user/login" element={<Login />}/>
        {/* <Route path="/upload-image/:userid" element={<AddImagePage />} /> */}
        {/* Thêm các Route khác cho các trang khác */}
        {/* Ví dụ Route cho trang About */}
        {/* <Route path="/about" element={<About />} /> */}
      </Routes>
    </React.StrictMode>
  </Router>
);

reportWebVitals();
