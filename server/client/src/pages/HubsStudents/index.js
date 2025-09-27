import React, { useEffect } from 'react';
import './styles.css'; // Estilo importado direto

function StudentHub({ pageTitle, headerTitle, welcomeMessage, developmentNote }) {
  useEffect(() => {
    document.title = pageTitle || 'Hub do Aluno';
  }, [pageTitle]);

  return (
    <div className="container">
      <header>
        <h1>{headerTitle || 'Hub do Aluno'}</h1>

        <p className="welcome-message">
          {welcomeMessage || (
            <>
              Bem-vindo ao <strong>Hub do Aluno</strong>! Aqui você pode acessar suas informações acadêmicas, materiais de estudo e muito mais.
            </>
          )}
        </p>
        <br /> 
        <p className="development-note">
          {developmentNote || (
            <strong><em>EM DESENVOLVIMENTO</em></strong>
          )}
        </p>
      </header>
    </div>
  );
}

export default StudentHub;
