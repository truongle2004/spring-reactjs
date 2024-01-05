import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { useEffect, useState } from "react";
import Stack from "@mui/material/Stack";
import Button from "@mui/material/Button";

export default function TextFieldsAndButtomSubmit() {
  const handleTextChange = (Account, Password) => {
    console.log(Account);
    console.log(Password);
  };
  const check = (AccountUser, PasswordUser) => {
    return AccountUser.length !== 0 && PasswordUser.length !== 0 ? true : false;
  };
  const checkContent = () => {
    if (check(AccountUser, PasswordUser)) return "success";
    return "error";
  };
  const [buttomResponse, setButtomRespone] = useState("Submit");
  const [AccountUser, setAccount] = useState("");
  const [PasswordUser, setPassword] = useState("");
  useEffect(() => {
    if (check(AccountUser, PasswordUser)) return setButtomRespone("Success");
    return setButtomRespone("Submit");
  });
  return (
    <>
      <Box
        component="form"
        sx={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",

          "& > :not(style)": { m: 1, width: "40ch" },
          position: "absolute",
          top: "250px",
          left: "555px",
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          onChange={(e) => {
            setAccount(e.target.value);
          }}
          color={checkContent(AccountUser)}
          id="outlined-basic-1"
          label="Account"
          variant="outlined"
        />

        <TextField
          onChange={(e) => {
            setPassword(e.target.value);
          }}
          color={checkContent(PasswordUser)}
          id="outlined-basic-2"
          label="Password"
          variant="outlined"
        />
      </Box>
      <Stack spacing={2} direction="row">
        <Button
          onClick={() => {
            handleTextChange(AccountUser, PasswordUser);
            if (check(AccountUser, PasswordUser)) {
              setButtomRespone("Success");
            } else {
              setButtomRespone("Error");
            }
          }}
          color={check(AccountUser, PasswordUser) ? "success" : "error"}
          style={{
            borderRadius: "30px",
            position: "absolute",
            left: "680px",
            top: "405px",
          }}
          variant="contained"
        >
          {buttomResponse}
        </Button>
      </Stack>
    </>
  );
}
