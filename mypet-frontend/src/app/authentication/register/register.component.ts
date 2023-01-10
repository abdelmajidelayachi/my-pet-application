import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private fb: FormBuilder, private authService: AuthService) { }

  registerForm !: FormGroup;


  ngOnInit(): void {

    this.registerForm = this.fb.group(
      {
        firstname: ['',[ Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
        lastname: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]]
      }
    )
  }

  get firstname() {
    return this.registerForm.get('firstname');
  }

  get lastname() {
    return this.registerForm.get('lastname');
  }

  get email() {
    return this.registerForm.get('email');
  }

  get password() {
    return this.registerForm.get('password');
  }

  get confirmPassword() {
    return this.registerForm.get('confirmPassword');
  }

  submitRegister() {
    this.authService.registerUser(this.registerForm.value).subscribe(
      (res: any) => {
        console.log(res.data);
      }
    )
  }










}
