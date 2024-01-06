// Import các thư viện cần thiết
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import EditOrderForm from './EditOrderForm'; // Đổi tên thành EditOrderForm để phản ánh chính xác

const OrderEdit = ({ match, history }) => {
  const [order, setOrder] = useState(null);
  const [User, setUsers] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    const orderId = localStorage.getItem('orderid');
    const fetchOrder = async () => {
      try {
        const response = await axios.get(`http://localhost:1412/order/api/admin/order-by-id/${orderId}`);
        setOrder(response.data);
        setLoading(false);
      } catch (error) {
        setError('Error fetching order details');
        setLoading(false);
      }
    };
   
    fetchOrder();
  }, []);
 
  const handleFormSubmit = async (formData) => {
    try {
      await axios.post(`http://localhost:1412/order/api/admin/updateorder/${order.order.orderid}`, formData);
    } catch (error) {
      console.error('Error submitting form:', error);
    }
  };

  const handleCancel = () => {
    history.push('/order-list');
  };

  return (
    <div className="container mt-5">
      <h2>Edit Order</h2>
      {loading && <p>Loading...</p>}
      {error && <p>{error}</p>}
      {order && (
        <EditOrderForm onSubmit={handleFormSubmit} onCancel={handleCancel} order={order} User={User} />
      )}
    </div>
  );
};

export default OrderEdit;