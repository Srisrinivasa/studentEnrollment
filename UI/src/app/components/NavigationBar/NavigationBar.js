import React from 'react';
import './NavigationBar.css';
import { Link, IndexLink } from 'react-router';

const NavBar = (props) => {
    let navBarSection =
        <section id="navBar-section">
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header" id="navBarHeading">
                        <span>Student Enrollment</span>
                    </div>
                </div>
            </nav>
        </section>;

    return navBarSection;
  };

export default NavBar;
