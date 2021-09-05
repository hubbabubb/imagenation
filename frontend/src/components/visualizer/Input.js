import {FormControl, InputGroup} from "react-bootstrap";
import obj from '../../images/svgs/solid/ad.svg'

export default function Input() {
    console.log(obj);
    return  <InputGroup className="dreamInput">
        <InputGroup.Text>I imagine a(n)...</InputGroup.Text>
        <FormControl as="textarea" aria-label="With textarea"/>
    </InputGroup>
}