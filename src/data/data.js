const data = {
	schema: {
		title: "Todo",
		type: "object",
		required: ["title"],
		properties: {
			title: {
				type: "string",
				title: "Task Name",
				description: "the task description",
				default: "A new task"
			},
			done: { type: "boolean", title: "Done?", default: false }
		}
	},
	uiSchema: {
		classNames: "custom-css-class",
		"ui:title": "my title"
	}
};

export default data;
