import {FormControl, InputGroup} from "react-bootstrap";

export default function Input(props) {
    const { setInputText } = props.methods;

    return  <InputGroup className="dreamInput">
        <InputGroup.Text>I imagine a(n)...</InputGroup.Text>
        <FormControl
            as="textarea"
            aria-label="With textarea"
            onChange={(e) =>setInputText(e.target.value)}
        />
    </InputGroup>
}