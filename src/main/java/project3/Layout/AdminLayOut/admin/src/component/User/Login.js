import React, { useState } from 'react';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const signin = () => {
    fetch('http://localhost:1412/security/user/signin', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: `username=${username}&password=${password}`,
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        // setSuccessMessage('Đăng nhập thành công!');
        localStorage.setItem('token', data.token);
        window.location.href = `/profile/user`;
        // Thêm mã giải mã token ở đây (dùng Base64)
        const parts = data.token.split('.');
        const payload = atob(parts[1]);
        console.log('Decoded Token Payload:', JSON.parse(payload));
      })
      .catch(error => {
        console.error('Error:', error);
        // setErrorMessage('Đăng nhập Không thành công!');
      });
  };

  return (
    <div className="limiter">
      <div className="container-login100">
        <div className="wrap-login100">
          <form className="login100-form validate-form" >
            <span className="login100-form-title p-b-43">
              Login to continue
            </span>
            {/* {successMessage &&   <label className="txt1" htmlFor="ckb1">
                {successMessage}
                </label>}
                {errorMessage &&   <label className="txt1" htmlFor="ckb1">
                {errorMessage}
                </label>} */}
            <label className="txt1" htmlFor="ckb1">
                  UserName
                </label>
                <br/>
            <div
            
              className="wrap-input100 validate-input"
              data-validate="Valid email is required: ex@abc.xyz"
            >
              
              <input
                className="input100"
                type="text"
                name="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                
              />
              <span className="focus-input100"></span>
              {/* <span className="label-input100">Email</span> */}
            </div>
            <label className="txt1" htmlFor="ckb1">
                  Password
                </label>
                <br/>
            <div
              className="wrap-input100 validate-input"
              data-validate="Password is required"
            >
              <input
                className="input100"
                type="password"
                name="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
              <span className="focus-input100"></span>
              {/* <span className="label-input100">Password</span> */}
            </div>

            <div className="flex-sb-m w-full p-t-3 p-b-32">
              <div className="contact100-form-checkbox">
                <input
                  className="input-checkbox100"
                  id="ckb1"
                  type="checkbox"
                  name="remember-me"
                />
                <label className="label-checkbox100" htmlFor="ckb1">
                  Remember me
                </label>
              </div>

              <div>
                <a href="#" className="txt1">
                  Forgot Password?
                </a>
              </div>
            </div>

            <div className="container-login100-form-btn">
              <button className="login100-form-btn" onClick={signin}>Login</button>
            </div>

            <div className="text-center p-t-46 p-b-20">
              <span className="txt2">or sign up using</span>
            </div>

            
          </form>

          <div
            className="login100-more"
            style={{ backgroundImage: "url('images/bg-01.jpg')" }}
          ></div>
        </div>
      </div>
    </div>
  );
};

export default Login;
