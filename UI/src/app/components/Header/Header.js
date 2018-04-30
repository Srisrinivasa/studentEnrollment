import React from 'react';
import './Header.css';

export const Header = (_props) => {
    let props = _props;
    return (
        <div className='heading h100'>
            <h2>{props.titleName}</h2>
        </div>
    );
}
