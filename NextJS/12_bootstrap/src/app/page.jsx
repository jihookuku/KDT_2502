//npm install bootstrap-react bootstrap
"use client"
import 'bootstrap/dist/css/bootstrap.min.css';
import {Button, ButtonToolbar} from "react-bootstrap";

export default function MainPage(){
    return (
        <div>
            <h3>Boot Strap Sample</h3>
            <>
                <Button variant="outline-primary">Primary</Button>
                <Button variant="outline-secondary">Secondary</Button>
                <Button variant="outline-success">Success</Button>
                <Button variant="warning">Warning</Button>
                <Button variant="danger">Danger</Button>
                <Button variant="info">Info</Button>
                <Button variant="light">Light</Button>
                <Button variant="dark">Dark</Button>
                <Button variant="link">Link</Button>
            </>
        </div>
    );
}