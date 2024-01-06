import React, { useState, useEffect } from 'react';

const ColorForm = ({ onSubmit, onCancel, color }) => {
  const [formData, setFormData] = useState({
    colorname: '',
    hexcode: '',
    // Add other properties related to the Color entity
  });

  useEffect(() => {
    if (color) {
      setFormData(color);
    } else {
      setFormData({
        colorname: '',
        hexcode: '',
        // Initialize other properties related to the Color entity
      });
    }
  }, [color]);

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

  const handleReset = () => {
    // Refresh the page when the reset button is clicked
    window.location.reload();
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-3 ">
        <label htmlFor="colorname" className="form-label">Color Name</label>
        <input
          type="text"
          className="form-control"
          id="colorname"
          name="colorname"
          value={formData.colorname}
          onChange={handleChange}
        />
      </div>
      {/* Add other input fields for hexcode and other properties related to the Color entity */}
      <div className="mb-3">
        <label htmlFor="hexcode" className="form-label">Hex Code</label>
        <input
          type="text"
          className="form-control"
          id="hexcode"
          name="hexcode"
          value={formData.hexcode}
          onChange={handleChange}
        />
      </div>
      {/* Add other input fields for hexcode and other properties related to the Color entity */}
      <button type="submit" className="btn btn-primary">Submit</button>
      <button onClick={handleReset} className="btn btn-primary">Cancel</button>
    </form>
  );
};

export default ColorForm;
