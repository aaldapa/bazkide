export const accessList = ()=>{

    console.log("accessList");

}


import { openUserForm } from './users-form.js';

export function initUserList() {
  console.log('[userList] Inicializado');

  // Inicializa área vacía
  $('#listaUsuarios').html('<li>Sin resultados</li>');
}

export function renderUserList(query) {
  console.log('[userList] Mostrando resultados para:', query);

  // Simular usuarios encontrados
  const html = `
    <li>${query} (usuario ficticio)
      <button class="editar" data-id="123">Editar</button>
    </li>
  `;
  $('#listaUsuarios').html(html);

  $('.editar').on('click', function () {
    const id = $(this).data('id');
    console.log('[userList] Editar usuario ID:', id);

    openUserForm(id); // Llama al formulario
  });
}