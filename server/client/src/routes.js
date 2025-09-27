import React from 'react';
import { 
    BrowserRouter, 
    Route, 
    Routes 
} from 'react-router-dom';

import Login from './pages/Login';
import FormsActivities from './pages/FormsActivities';

export default function Rotas() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/login-adai-college' exact Component={Login} />
                <Route path='/activities-adai-college' Component={FormsActivities} />
                <Route path='/studenthub-adai-college' Component={StudentHub} />
            </Routes>
        </BrowserRouter>
    )
}