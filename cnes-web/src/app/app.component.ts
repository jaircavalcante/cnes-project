import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cnes-web';

  constructor(private router: Router ){}

  consultarDados(){
    this.router.navigate(['/consultar-dados']);
  }

  importarArquivo(){
    this.router.navigate(['/importar-arquivo']);
  }
}
