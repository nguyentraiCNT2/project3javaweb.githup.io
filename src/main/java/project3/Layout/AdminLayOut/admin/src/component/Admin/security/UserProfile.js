import React, { useEffect, useState } from 'react';
import Menu from '../Layout/menu';
const UserProfile = () => {
  const [username, setUsername] = useState('');
  const [userId, setUserId] = useState('');
  const [role, setRole] = useState('');

  useEffect(() => {
    const token = localStorage.getItem('token');
    const parts = token.split('.');
    const payload = JSON.parse(atob(parts[1]));
    const userId = payload.sub;
    if (token && userId) {
      fetch(`http://localhost:1412/security/profile/user/${userId}`, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${token}`,
        },
      })
        .then(response => response.json())
        .then(data => {
          setUsername(data.username);
          setUserId(data.userid);
          setRole(data.roleid === 1 ? 'User' : 'Admin');
        })
        .catch(error => {
          console.error('Error:', error);
        });
    }
  }, []);
  const signout = () => {
    // Xóa thông tin đăng nhập từ Local Storage
    localStorage.removeItem('token');
    localStorage.removeItem('userid');
      window.location.href='/user-list';
  };
  return (
    <div className="profile-container">
        <Menu />
      <h2>User Profile</h2>
      <label htmlFor="username">Username:</label>
      <p>{username}</p>

      <label htmlFor="userid">User ID:</label>
      <p>{userId}</p>

      <label htmlFor="roleid">Role ID:</label>
      <p>{role}</p>
      <label htmlFor="roleid">--------------------------------------------</label>
      <p></p>
      <button onClick={signout}>Đăng xuất</button>
    </div>
  );
};

export default UserProfile;
