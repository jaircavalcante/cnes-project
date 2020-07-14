import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UploadFileComponent } from './componentes/upload-file/upload-file.component';
import { ListaCNESComponent } from './componentes/lista-cnes/lista-cnes.component';


const routes: Routes = [
  { path: 'importar-arquivo', component: UploadFileComponent },
  { path: 'consultar-dados', component: ListaCNESComponent },
  { path: '',   redirectTo: '/importar-arquivo', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
