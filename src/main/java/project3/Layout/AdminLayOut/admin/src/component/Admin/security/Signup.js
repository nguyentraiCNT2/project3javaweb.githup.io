// src/components/RegisterForm.js
import React, { useState } from 'react';
import axios from '../../../axios';
import { Link } from 'react-router-dom';
import Menu from '../Layout/menu';
const SignUpAdmin = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    confirmPassword: '',
    firstname: '',
    lastname: '',
    phone: '',
    email: '',
    gender: '',
  });

  const [error, setError] = useState('');
  const [passerror, setPasserror] = useState('');
  const [ok, setOk] = useState('');
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
    setError(''); // Clear error when user makes changes
    setOk('');
    setPasserror('');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Kiểm tra xác nhận mật khẩu
    if (formData.password !== formData.confirmPassword) {
      setPasserror('Mật khẩu và xác nhận mật khẩu không khớp');
      return;
    }
    else if(formData.password.length < 6){
      setPasserror('Mật khẩu tối thiểu 6 kí tự ');
      return;
    }
    else if(formData.password.length > 20){
      setPasserror('Mật khẩu tối đa 20 kí tự ');
      return;
    }
    else if(/\s/.test(formData.password)){
      setPasserror('Mật khẩu không được chứa khoảng trắng');
    return;
    }
    else if(formData.password === formData.username){
      setPasserror('Mật khẩu không được chứa tên đăng nhập');
    return;
    }else{
    try {
      const response = await axios.post('http://localhost:1412/security/signup', formData);
      console.log('Signup Successful:', response.data);
      window.location.href = `/admin/login`; 
      // Handle success, e.g., redirect to login page
    } catch (error) {
      console.error('Signup Failed:', error.response?.data);
      setError(error.response?.data?.error || 'Tài khoản đã tồn tại');
      // Handle error, e.g., display error message
    }
  }
  };

  return (
    <div>
      <Menu />
      <h2>Register</h2>
      {error && <div style={{ color: 'red' }}>{error}</div>}
    
      <form onSubmit={handleSubmit}>
        <label>
          Username:
          <input type="text" name="username" value={formData.username} onChange={handleChange} required />
        </label>
        <br/>
        {passerror && <div style={{ color: 'red' }}>{passerror}</div>}
       
        <label>
          Password:
          <input type="password" name="password" value={formData.password} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Confirm Password:
          <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required />
        </label>
        <br />
        <label>
          First Name:
          <input type="text" name="firstname" value={formData.firstname} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Last Name:
          <input type="text" name="lastname" value={formData.lastname} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Phone:
          <input type="text" name="phone" value={formData.phone} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Email:
          <input type="email" name="email" value={formData.email} onChange={handleChange} required />
        </label>
        <br />
        <label>
          Gender:
          <select name="gender" value={formData.gender} onChange={handleChange} required>
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
          </select>
        </label>
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default SignUpAdmin;
