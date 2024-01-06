
import React, { useState, useEffect } from 'react';
import axios from '../../../axios';
const EditOrderForm = ({ onSubmit, onCancel, order, User }) => {
  const [users, setUsers] = useState(null);
  const [error, setError] = useState(null);
  const [formData, setFormData] = useState({
    orderqty: '',
    deliverydate: '',
    orderstatus: '',
    orderpay: '',
    ordercancel: '',
    orderdate:'',
  });
  
  
  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await axios.get(`http://localhost:1412/user/api/admin/user-by-id/${order.order.userid}`);
        setUsers(response.data);
      } catch (error) {
        setError('Error fetching user details');
      }
    };

    fetchUsers();
  }, []);
  useEffect(() => {
    const fetchProcude = async () => {
      try {
        const response = await axios.get(`http://localhost:1412/user/api/admin/user-by-id/${order.order.userid}`);
        setUsers(response.data);
      } catch (error) {
        setError('Error fetching user details');
      }
    };

    fetchProcude();
  }, []);
  useEffect(() => {
  

    if (order) {
      setFormData({
        deliverydate: order.order.deliverydate || '',
        orderdate: order.order.orderdate || '',
        orderqty: order.order.orderqty || '',
        orderstatus: order.order.orderstatus || '',
        orderpay: order.order.orderpay || '',
        ordercancel: order.order.ordercancel || '',
        // Cập nhật các trường mới hoặc cập nhật các trường cần thiết
      });
    }
  }, [order]);

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  const formatDateTime = (timestamp) => {
    if (!timestamp) return ''; // Handle cases where timestamp is undefined or null
  
    const date = new Date(parseInt(timestamp, 10)); // Parse the timestamp as an integer
    const options = { year: 'numeric', month: 'numeric', day: 'numeric', hour: 'numeric', minute: 'numeric' };
    const formattedDateTime = date.toLocaleString(undefined, options); // Use toLocaleString with options
  
    return formattedDateTime;
  };
  return (
    <div>
    <form onSubmit={handleSubmit} style={{ marginBottom: '50px' }} >
    <div className=" d-flex col-sm-12 col-md-9" >
      <div className=" d-flex">
        <label htmlFor="orderqty" className="form-label">Order Quantity: {formData.orderqty}</label>
      </div>
      
      <div >
        <label htmlFor="orderqty" className="form-label">Order Date </label>
        <input
            type="text"
          className="form-control"
          id="orderdate"
          name="orderdate"
          value={formatDateTime(formData.orderdate)}
          onChange={handleChange}
          readOnly
        />
      </div>
      
      <div >
        <label htmlFor="orderqty" className="form-label">Order deliverydate </label>
        <input
            type="date"
          className="form-control"
          id="deliverydate"
          name="deliverydate"
          value={formData.deliverydate}
          onChange={handleChange}
        />
      </div>
   
      </div>
    
      <div className=" d-flex  mt-5"  >
      <div className="  mt-4 col-sm-12 col-md-2"  >
      <label htmlFor="ordercancel"  aria-label="First name" class="form-control  ">{users?.firtname} {users?.lastname}</label>
      </div>
      <div  style={{padding:'20px 10px'}}>
          
      <label htmlFor="ordercancel" aria-label="First name" class="form-control  ">Số điện thoại: {users?.phone}</label>

      
      </div>
      <div  style={{padding:'20px 10px'}}>
      <label htmlFor="ordercancel" aria-label="First name" class="form-control  ">Email: {users?.email}</label>
      </div>
      </div>
      <div className=" d-flex">
      <div  style={{padding:'20px 10px'}}>
        <label htmlFor="orderstatus" className="form-label">Order Status</label>
        <select
          type="text"
          className="form-control"
          id="orderstatus"
          name="orderstatus"
          value={formData.orderstatus}
          onChange={handleChange}
        >
          <option value="">--- Chọn trạng thái ---</option>
          <option value="Đang chuẩn bị hàng">Đang chuẩn bị hàng</option>
          <option value="Đang giao hàng">Đang giao hàng </option>
          <option value="Đã giao ">Đã giao </option>

          </select>
      </div>

      <div  style={{padding:'20px 10px'}}>
        <label htmlFor="orderpay" className="form-label">Order Pay</label>
        <select
          type="text"
          className="form-control"
          id="orderpay"
          name="orderpay"
          value={formData.orderpay}
          onChange={handleChange}
        >
           <option value="">--- Chọn trạng thái ---</option>
          <option value="chưa thanh toán">Chưa thanh toán</option>
          <option value="Đã thanh toán">Đã thanh toán</option>
          </select>
      </div>

      <div  style={{padding:'20px 10px'}}>
        <label htmlFor="ordercancel" className="form-label">Order Cancel</label>
        <select
          type="text"
          className="form-control"
          id="ordercancel"
          name="ordercancel"
          value={formData.ordercancel}
          onChange={handleChange}
        >
           <option value="">--- Chọn trạng thái ---</option>
          <option value="Xác nhận">Xác nhận</option>
          <option value="Đã hủy">Đã hủy</option>
          </select>
      </div>
      </div>

      <br/>
      <button type="submit" className="btn btn-primary">Submit</button>
      <button onClick={onCancel} className="btn btn-danger ms-2">Cancel</button>
      
    </form>
    </div>
  );
};

export default EditOrderForm;