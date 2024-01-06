import React, { useEffect, useState } from 'react';
import Menu from '../Layout/menu';

const AdminProfile = () => {
  const [username, setUsername] = useState('');
  const [userId, setUserId] = useState('');
  const [role, setRole] = useState('');
  const [images, setImages] = useState('');
  const [email, setEmail] = useState('');
  const [firtname, setFirtname] = useState('');
  const [lastname, setLastname] = useState('');
  const [phone, setPhone] = useState('');
  const [gender, setGender] = useState('');
  useEffect(() => {
    const token = localStorage.getItem('token');
    const parts = token.split('.');
    const payload = JSON.parse(atob(parts[1]));
    const userId = payload.sub;
    
    if (token && userId) {
      fetch(`http://localhost:1412/security/profile/admin/${userId}`, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${token}`,
        },
      })
        .then(response => response.json())
        .then(data => {
          setPhone(data.phone);
          setGender(data.gender);
          setFirtname(data.firtname);
          setLastname(data.lastname)
          setUsername(data.username);
          setImages(data.images)
          setUserId(data.userid);
          setEmail(data.email)
          setRole(data.roleid === 1 ? 'User' : 'Admin');
        })
        .catch(error => {
          console.error('Error:', error);
        });
    }
  }, []);

  const signout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('userid');
    window.location.href='/user-list';
  };

  return (
    <section className="h-100 gradient-custom-2">
      <div className="container py-5 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col col-lg-9 col-xl-7">
            <div className="card">
              <div className="rounded-top text-white d-flex flex-row" style={{ backgroundColor: '#000', height: '200px' }}>
                <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '150px' }}>
                  <img src={`/images/${images}`}
                    alt="Generic placeholder image" className="img-fluid img-thumbnail mt-4 mb-2"
                    style={{ width: '150px', zIndex: 1 }}
                  />
                  <button type="button" className="btn btn-outline-dark" data-mdb-ripple-color="dark" style={{ zIndex: 1 }}>
                    Edit profile
                  </button>
                </div>
                <div className="ms-3" style={{ marginTop: '130px' }}>

                  <h5>{firtname} {lastname}</h5>
                  <h5>{email}</h5>
                </div>
              </div>
              <div className="p-4 text-black" style={{ backgroundColor: '#f8f9fa' }}>
                <div className="d-flex justify-content-end text-center py-1">
                  <div>
                    <p className="small text-muted mb-0">{role}</p>
                  </div>
              
                </div>
              </div>
              <div className="card-body p-4 text-black">
                <div className="mb-5">
                  <p className="lead fw-normal mb-1">About</p>
                  <div className="p-4" style={{ backgroundColor: '#f8f9fa' }}>
                    <p className="font-italic mb-1">{phone}</p>
                    <p className="font-italic mb-1">{gender}</p>
                  </div>
                </div>
                <div className="d-flex justify-content-between align-items-center mb-4">
                  <p className="mb-0"><a href="/user-list" className="text-muted">Quay lại</a></p>
                </div>
                
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AdminProfile;
