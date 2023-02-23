import {useState} from "react";

import {NavLink as ReactLink} from "react-router-dom";

import { Navbar,NavbarBrand,NavbarToggler,Collapse,Nav,NavItem,NavLink,UncontrolledDropdown,DropdownToggle,DropdownMenu,DropdownItem,NavbarText } from "reactstrap";
const CustomNavbar =() =>{
  const [isOpen,setIsOpen] = useState(false)
  return (
    <div>
      <Navbar 
      color= "dark"
      dark
      expanded="md"
      fixed="">
        <NavbarBrand tag = {ReactLink} to="/">
        Blog App</NavbarBrand>
        <NavbarToggler onClick={()=>setIsOpen(!isOpen)} />
        <Collapse  navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink tag={ReactLink} to = "/about">
              About 
              </NavLink>
            </NavItem>
            <NavItem>
            <NavLink  tag={ReactLink} to = "/login">
                Login
              </NavLink>
            </NavItem>
            <NavItem>
            <NavLink tag = {ReactLink} t=  "/signup">
                Signup
              </NavLink>
            </NavItem>
            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
                Options
              </DropdownToggle>
              <DropdownMenu right>
                <DropdownItem tag = {ReactLink }to ="/services">Services</DropdownItem>
                <DropdownItem>Contact us</DropdownItem>
                <DropdownItem divider />
                <DropdownItem>You tube</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <NavbarText>you tube</NavbarText>
        </Collapse>
      </Navbar>
    </div>
  );
}
export default CustomNavbar;