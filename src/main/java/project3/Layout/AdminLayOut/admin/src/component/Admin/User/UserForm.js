import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const UserForm = ({ onSubmit, onCancel, user }) => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    firtname: '',
    lastname: '',
    phone: '',
    email: '',
    images: '',
    gender: '',
    status: '',
  });

  useEffect(() => {
    if (user) {
      setFormData(user);
    } else {
      setFormData({
        username: '',
        password: '',
        firtname: '',
        lastname: '',
        phone: '',
        email: '',
        images: '',
        gender: '',
        status: '',
      });
    }
  }, [user]);

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleReset = () => {
    // Làm mới trang khi nút được nhấn
    window.location.reload();
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  return (
    <div className="d-flex ">
        <div className="container mt-5">
      <Form onSubmit={handleSubmit} className="user-form">
        <Form.Group className="mb-3"   controlId="username">
          <Form.Label>Username</Form.Label>
        <Form.Control
          type="text"
          value={formData.username}
          onChange={handleChange}
          name="username"
          maxLength={255}
        />
      </Form.Group>
      {/* Add other input fields for password, firstname, lastname, phone, email, images, gender, status */}
      <Form.Group className="mb-3"   controlId="password">
        <Form.Label>Password</Form.Label>
        <Form.Control
          type="password"
          value={formData.password}
          onChange={handleChange}
          name="password"
          maxLength={255}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="firtname">
        <Form.Label>Firtname</Form.Label>
        <Form.Control
          type="text"
          value={formData.firtname}
          onChange={handleChange}
          name="firtname"
          maxLength={255}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="lastname">
        <Form.Label>Lastname</Form.Label>
        <Form.Control
          type="text"
          value={formData.lastname}
          onChange={handleChange}
          name="lastname"
          maxLength={255}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="phone">
        <Form.Label>Phone</Form.Label>
        <Form.Control
          type="text"
          value={formData.phone}
          onChange={handleChange}
          name="phone"
          maxLength={255}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="email">
        <Form.Label>Email</Form.Label>
        <Form.Control
          type="text"
          value={formData.email}
          onChange={handleChange}
          name="email"
          maxLength={255}
        />
      </Form.Group>
    
  
      <Form.Group className="mb-3" controlId="gender">
  <Form.Label>Gender</Form.Label>
  <Form.Control
    as="select"
    type="text"
    value={formData.gender}
    onChange={handleChange}
    name="gender"
  >
    <option value="">Select Gender</option>
    <option value="Nam">Nam</option>
    <option value="Nữ">Nữ</option>
    <option value="Khác">Khác</option>
    <option value="Không muốn nói">Không muốn nói</option>
  </Form.Control>
</Form.Group>

<Form.Group className="mb-3" controlId="status">
  <Form.Label>Status</Form.Label>
  <Form.Control
    as="select"
    value={formData.status}
    onChange={handleChange}
    name="status"
  >
    <option value="">Select Status</option>
    <option value={true}>True</option>
    <option value={false}>False</option>
  </Form.Control>
</Form.Group>
      <Button variant="primary" type="submit" className="mr-2">
          Submit
        </Button>
        <Button variant="secondary" onClick={handleReset}>
          Cancel
        </Button>
    </Form>
    <br/>
    <br/>
    <br/>
    </div>
   
    </div>
  );
};

export default UserForm;
