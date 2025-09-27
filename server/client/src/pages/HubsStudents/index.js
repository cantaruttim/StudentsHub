import React from 'react';
import './style/style.css'; // Estilo importado direto

// Opcional: se quiser controlar o <title> da aba
import { Helmet } from 'react-helmet';

function StudentHub({ pageTitle, headerTitle, welcomeMessage, developmentNote }) {
  return (
    <div className="container">
      {/* Head da página */}
      <Helmet>
        <title>{pageTitle || 'Hub do Aluno'}</title>
      </Helmet>

      <header>
        <h1>{headerTitle || 'Hub do Aluno'}</h1>

        <p className="welcome-message">
          {welcomeMessage || (
            <>
              Bem-vindo ao <strong>Hub do Aluno</strong>! Aqui você pode acessar suas informações acadêmicas, materiais de estudo e muito mais.
            </>
          )}
        </p>

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
