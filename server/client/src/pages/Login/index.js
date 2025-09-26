import React, { useState } from 'react';
import './style.css';

function Login() {
  const [registrationNumber, setRegistrationNumber] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Matrícula:', registrationNumber);
    console.log('Senha:', password);
  };

  return (
    <div className="page">
      <h1 className="main-title">Área do Aluno</h1>

      <div className="container">
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="registrationNumber">Matrícula:</label>
            <input
              type="text"
              id="registrationNumber"
              name="registrationNumber"
              value={registrationNumber}
              onChange={(e) => setRegistrationNumber(e.target.value)}
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Senha:</label>
            <input
              type="password"
              id="password"
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <div className="buttons">
            <button type="submit" className="submit-btn">Entrar</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
