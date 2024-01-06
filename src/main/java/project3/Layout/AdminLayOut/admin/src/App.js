// src/App.js
import React from 'react';
import UserList from './component/Admin/User/UserList';
const App = () => {
    return (
      <div className='layout'>
      <UserList />
      {/* <RoleList /> */}
      {/* <AddUserPage/> */}
    </div>
    );
};

export default App;
