// AddImagePage.jsx

import React, { useState } from 'react';
import ImageUploadComponent1 from './ImageUploadComponent1'; // Điều chỉnh đường dẫn tùy thuộc vào cấu trúc dự án
import ImageUploadComponent2 from './ImageUploadComponent2';
import ImageUploadComponent3 from './ImageUploadComponent3';
import ImageUploadComponent4 from './ImageUploadComponent4';
import ImageUploadComponent5 from './ImageUploadComponent5';
import Menu from '../Layout/menu';
import Navbar from '../Layout/navbar';
import { Link } from 'react-router-dom';
const AddproductImagePage = ({ match,history }) => {
  const [uploadSuccess1, setUploadSuccess1] = useState('');
  const [uploadSuccess2, setUploadSuccess2] = useState('');
  const [uploadSuccess3, setUploadSuccess3] = useState('');
  const [uploadSuccess4, setUploadSuccess4] = useState('');
  const [uploadSuccess5, setUploadSuccess5] = useState('');
  const [uploadError, setUploadError] = useState('');
 const productname = localStorage.getItem('productname');
  const handleImageUpload = async (formData) => {
    try {
      await fetch(`http://localhost:1412/admin/product/api/${productname}/upload-image-so-1`, {
        method: 'POST',
        body: formData,
      });
      setUploadSuccess1('Image 1 uploaded successfully');
      setUploadError('');
      // history.push('/user-list');
    } catch (error) {
      console.error('Error uploading image:', error);
      setUploadSuccess1('');
      setUploadError('Error uploading image');
    }
  };
  const handleImageUpload2= async (formData) => {
    try {
      await fetch(`http://localhost:1412/admin/product/api/${productname}/upload-image-so-2`, {
        method: 'POST',
        body: formData,
      });
      setUploadSuccess2('Image 2 uploaded successfully');
      setUploadError('');
      // history.push('/user-list');
    } catch (error) {
      console.error('Error uploading image:', error);
      setUploadSuccess2('');
      setUploadError('Error uploading image');
    }
  };
  const handleImageUpload3 = async (formData) => {
    try {
      await fetch(`http://localhost:1412/admin/product/api/${productname}/upload-image-so-3`, {
        method: 'POST',
        body: formData,
      });
      setUploadSuccess3('Image 3 uploaded successfully');
      setUploadError('');
      // history.push('/user-list');
    } catch (error) {
      console.error('Error uploading image:', error);
      setUploadSuccess3('');
      setUploadError('Error uploading image');
    }
  };
  const handleImageUpload4 = async (formData) => {
    try {
      await fetch(`http://localhost:1412/admin/product/api/${productname}/upload-image-so-4`, {
        method: 'POST',
        body: formData,
      });
      setUploadSuccess4('Image 4 uploaded successfully');
      setUploadError('');
      // history.push('/user-list');
    } catch (error) {
      console.error('Error uploading image:', error);
      setUploadSuccess4('');
      setUploadError('Error uploading image');
    }
  };
  const handleImageUpload5 = async (formData) => {
    try {
      await fetch(`http://localhost:1412/admin/product/api/${productname}/upload-image-so-5`, {
        method: 'POST',
        body: formData,
      });
      setUploadSuccess5('Image 5 uploaded successfully');
      setUploadError('');
      // history.push('/user-list');
    } catch (error) {
      console.error('Error uploading image:', error);
      setUploadSuccess5('');
      setUploadError('Error uploading image');
    }
  };
    const handleReset = () => {
      // Làm mới trang khi nút được nhấn
      window.location.href = '/product-list';
    };
  
  return (
    <div id="wrapper">
    <Navbar />
    <div id="content-wrapper" className="d-flex flex-column">
      <div id="content" className="d-flex">
        <div class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
          <Menu />
        </div>
        <div className="container col-sm-12 col-md-6">
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Add Product images</h6>
            </div>
            <div class="card-body">
    <div  >
      {uploadSuccess1 && <div className="alert alert-success mt-3">{uploadSuccess1}</div>}
      {uploadError && <div className="alert alert-danger mt-3">{uploadError}</div>}
      <ImageUploadComponent1 onImageUpload={handleImageUpload}  />
      <br/>
      <br/>
      {uploadSuccess2 && <div className="alert alert-success mt-3">{uploadSuccess2}</div>}
      <ImageUploadComponent2 onImageUpload={handleImageUpload2}  />
      <br/>
      <br/>
      {uploadSuccess3 && <div className="alert alert-success mt-3">{uploadSuccess3}</div>}
      <ImageUploadComponent3 onImageUpload={handleImageUpload3}  />
      <br/>
      <br/>
      {uploadSuccess4 && <div className="alert alert-success mt-3">{uploadSuccess4}</div>}
      <ImageUploadComponent4 onImageUpload={handleImageUpload4}  />
      <br/>
      <br/>
      {uploadSuccess5 && <div className="alert alert-success mt-3">{uploadSuccess5}</div>}
      <ImageUploadComponent5 onImageUpload={handleImageUpload5}/>
      <br/>
      <br/>
      <br/>
      <div>
      <button onClick={handleReset} className="btn btn-secondary">Close</button>
      </div>
    </div>
    </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddproductImagePage;
