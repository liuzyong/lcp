import React from 'react';
import Form from "@rjsf/antd";
import { useState } from "react";
import MyData from "../../../data/data";

const AntdSchema = () => {
	const [formData, setFormData] = useState({
		title: "First task11",
		done: false
	});
	return (
		<div className="App">
			<Form
				schema={MyData.schema}
				uiSchema={MyData.uiSchema}
				formData={formData}
				onChange={(e) => setFormData(e.formData)}
			/>
		</div>
	);
};
export default AntdSchema;
