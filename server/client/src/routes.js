import React from 'react';
import { 
    BrowserRouter, 
    Route, 
    Routes 
} from 'react-router-dom';

import Login from './pages/Login';

export default function Rotas() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/login-adai-college' Component={Login} />
            </Routes>
        </BrowserRouter>
    )
}