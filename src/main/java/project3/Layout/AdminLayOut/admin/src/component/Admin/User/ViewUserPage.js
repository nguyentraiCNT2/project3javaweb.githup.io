// src/components/ViewUserPage.js
import React from 'react';
import { Link } from 'react-router-dom';

const ViewUserPage = ({ user, onCancel }) => {
  return (
    <div className="container mt-5">
      <h1>User Details</h1>
      <div>
        <strong>Username:</strong> {user.username}
      </div>
      <div>
        <strong>Password:</strong> {user.password}
      </div>
      <div>
        <strong>FullName:</strong> {user.firtname} {user.lastname} 
      </div>
      <div>
        <strong>Email:</strong> {user.email}
      </div>
      <div>
        <strong>phone:</strong> {user.phone}
      </div>
      <div>
        <strong>images:</strong> {user.images}
      </div>
      <div>
        <strong>gender:</strong> {user.gender}
      </div>
      <div>
        <strong>status:</strong> {user.status ? 'Online':'Offline'}
      </div>
      <div>
        <strong>roleid:</strong> {user.roleid ? 'User':'Admin'}
      </div>
      {/* Thêm các trường khác của người dùng */}
      <Link to="/user-list" className="btn btn-secondary" onClick={onCancel}>
        Close
      </Link>
    </div>
  );
};

export default ViewUserPage;
