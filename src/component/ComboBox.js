import * as React from "react";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";

export default function ComboBox() {
	// const [value, setValue] = React.useState(top100Films[0]);
	const [inputValue, setInputValue] = React.useState();
	return (
		<div>
			{/* <div>{`value is : ${value !== null ? `'${value.label}'` : "null"}`}</div> */}
			<div>{`inputValue is '${inputValue}'`}</div>
			<Autocomplete
				// value={value}
				// onChange={(even, newValue) => {
				// 	setValue(newValue);
				// }}
				inputValue={inputValue}
				// 必须是两个参数 event不能省略
				onInputChange={(event, newValue) => {
					setInputValue(newValue);
				}}
				disablePortal
				id="combo-box-demo"
				options={Themes}
				// sx={{ width: 300 }}
				renderInput={(params) => (
					<TextField {...params} label="Select themes" variant="standard" />
				)}
			/>
		</div>
	);
}

// Top 100 films as rated by IMDb users. http://www.imdb.com/chart/top
const Themes = [
	{ label: "Semantic UI" },
	{ label: "antd" },
	{ label: "fluent-ui" },
	{ label: "material-ui" },
	{ label: "Bootstrap 4" }
];
