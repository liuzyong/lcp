import React from 'react';
import AmisFrom from "./Amis";
import JsonSchemaFrom from "./JsonShemaFrom";

const PROFORM = "AMIS1"

const ProFrom = () => {
    return (
        <div >
            {
                PROFORM == "AMIS" ? <AmisFrom /> : <JsonSchemaFrom />
            }
        </div>

    )
}
export default ProFrom;