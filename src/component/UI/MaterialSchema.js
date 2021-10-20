import Form from "@rjsf/material-ui";
import { useState } from "react";
import MyData from "../../data/data";

const MaterialSchema = () => {
	const [formData, setFormData] = useState({
		blendMode: "screen",
		colorMask: ['#00ff00', '#0000ff', '#ff0000'],
		currentColor: "#0000ff",
		done: false,
		title: "First task11",
		toggleMask: true
	});

	// // const formData = {
	// //   title: "First task11",
	// //   done: false
	// // };
	const onSubmit = () => {
		console.log(formData);
	}

	return (
		<div className="App">
			<Form
				schema={MyData.schema}
				uiSchema={MyData.uiSchema}
				formData={formData}
				onChange={(e) => setFormData(e.formData)}
				onSubmit={onSubmit}
			/>
		</div>
	);
};
export default MaterialSchema;
